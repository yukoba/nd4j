package org.nd4j.linalg.lossfunctions;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.nd4j.linalg.BaseNd4jTest;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.activations.IActivation;
import org.nd4j.linalg.activations.impl.*;
import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.buffer.util.DataTypeUtil;
import org.nd4j.linalg.api.iter.NdIndexIterator;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.factory.Nd4jBackend;
import org.nd4j.linalg.lossfunctions.impl.*;
import org.nd4j.linalg.api.buffer.util.DataTypeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Alex on 08/08/2016.
 */
@Slf4j
public class LossFunctionGradientChecks extends BaseNd4jTest {

    private static final double maxRelError = 5.0; //5% relative error
    DataBuffer.Type initialType;

    public LossFunctionGradientChecks(Nd4jBackend backend) {
        super(backend);
        this.initialType = Nd4j.dataType();
    }

    @Before
    public void before() throws Exception {
        super.before();

        Nd4j.zeros(1);
        DataTypeUtil.setDTypeForContext(DataBuffer.Type.DOUBLE);

        Nd4j.getRandom().setSeed(123);
    }

    @Test
    public void testLossFunctionGradients(){

        ILossFunction[] lossFns = {new LossMSE(),
        new LossL1(),
        new LossMAE(),
        new LossL2(),
        new LossMAPE(),
        new LossMSLE(),
        new LossPoisson()
        };

        for (int i=0; i< lossFns.length; i++) {
            System.out.println ("==================================================");
            System.out.println(lossFns[i].toString());
            doGradientCheck(lossFns[i],true);
        }

        lossFns = new ILossFunction[]{
                //new LossBinaryXENT(), //fails with softmax - label size 1 and 2
                new LossMCXENT(), //fails with softmax - label size 3
                //new LossKLD(), //fails with everything
                //new LossNegativeLogLikelihood(), //fails with softmax
                //new LossCosineProximity(), //fails with nans
                new LossHinge(),
                new LossSquaredHinge()
        };

        for (int i=0; i< lossFns.length; i++) {
            System.out.println ("==================================================");
            System.out.println(lossFns[i].toString());
            doGradientCheck(lossFns[i],false);
        }

    }

    public static void doGradientCheck(ILossFunction lossfn, boolean regression) {
        double epsilon = 1e-6;
        int totalNFailures = 0;
        double maxRelError = 5.0; // in %

        int[] labelSizes = new int[]{1, 2, 3};
        String[] activationFns = new String[]{"cube",
                "leakyrelu",
                "identity",
                "tanh",
                "hardtanh",
                "softsign",
                "hardsigmoid",
                "sigmoid",
                "elu",
                "softplus",
                "relu"};

         if (!regression) {

             activationFns = new String [] {
                     "softmax",
                     "hardsigmoid",
                     "sigmoid"};

             if(lossfn instanceof LossBinaryXENT) {
                 labelSizes = new int[] {1,2};
             }
         }


        for (int i = 0; i < activationFns.length; i++) {

            System.out.println("Running checks for "+activationFns[i]);

            String activationS = activationFns[i];
            IActivation activation = Activation.fromString(activationS).getActivationFunction();

            List<INDArray> labelList = makeLabels(regression ? "regression":"classification",labelSizes);
            List<INDArray> preOutputList = makeLabels("preout",labelSizes);

            for (int j=0; j<labelSizes.length; j++) {

                if(!regression && labelSizes[j]==1) continue;

                System.out.println("\tRunning check for length " + labelSizes[j]);

                INDArray label = labelList.get(j);
                INDArray preOut = preOutputList.get(j);
                INDArray grad = lossfn.computeGradient(label.dup(),preOut.dup(),activation,null);

                NdIndexIterator iterPreOut = new NdIndexIterator(preOut.shape());

                while (iterPreOut.hasNext()) {
                    int[] next = iterPreOut.next();
                    //checking gradient with total score wrt to each output feature in label
                    double before = preOut.getDouble(next);
                    preOut.putScalar(next, before + epsilon);
                    double scorePlus = lossfn.computeScore(label.dup(), preOut.dup(), activation, null, true);
                    preOut.putScalar(next, before - epsilon);
                    double scoreMinus = lossfn.computeScore(label.dup(), preOut.dup(), activation, null, true);
                    preOut.putScalar(next, before);

                    double scoreDelta = scorePlus - scoreMinus;
                    double numericalGradient = scoreDelta / (2 * epsilon);
                    double analyticGradient = grad.getDouble(next);
                    double relError = Math.abs(analyticGradient - numericalGradient) * 100 / (Math.abs(numericalGradient));
                    if( analyticGradient == 0.0 && numericalGradient == 0.0 ) relError = 0.0;
                    if (relError > maxRelError || Double.isNaN(relError)) {
                        System.out.println("\t\tParam " + Arrays.toString(next) + " FAILED: grad= " + analyticGradient + ", numericalGrad= " + numericalGradient
                               + ", relErrorPerc= " + relError + ", scorePlus=" + scorePlus + ", scoreMinus= " + scoreMinus);
                        totalNFailures++;
                    } else {
                        //System.out.println("\t\tParam " + Arrays.toString(next) + " passed: grad= " + analyticGradient + ", numericalGrad= " + numericalGradient
                        //        + ", relError= " + relError + ", scorePlus=" + scorePlus + ", scoreMinus= " + scoreMinus);
                    }
                }
            }
        }

        if(totalNFailures > 0) System.out.println("DONE:\n\tGradient check failed for loss function:"+lossfn.toString()+"; total num failures = " + totalNFailures);
        assert(totalNFailures == 0);
    }


    /*
        Return valid labels for different activation functions with given labelSize
     */
    public static List<INDArray> makeLabels(String labelType,int[]labelSize) {
        List<INDArray> returnVals = new ArrayList<>(labelSize.length);
        for (int i=0; i< labelSize.length; i++) {
            int aLabelSize = labelSize[i];
            Random r = new Random();
            double[] someVals = new double[aLabelSize];
            double someValsSum = 0;
            for (int j=0; j<aLabelSize; j++) {
                double transformVal=0;
                switch (labelType) {
                    case "regression":
                        transformVal = 0.5*r.nextDouble()+0.4;
                        break;
                    // random 0s and 1s
                    case "classification":
                        transformVal = r.nextBoolean() ? 1:0;
                        break;
                    case "preout":
                        transformVal = r.nextDouble();
                        break;
                }
                someVals[j] = transformVal;
            }
            returnVals.add(Nd4j.create(someVals));
        }
        return returnVals;
    }

    @After
    public void after() {
        DataTypeUtil.setDTypeForContext(this.initialType);
        System.out.println("AFTER DATATYPE HERE: "+ Nd4j.dataType());
    }

    @Override
    public char ordering() {
        return 'f';
    }

}
