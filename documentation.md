---
layout: page
title: "ND4J Syntax"
description: ""
---
{% include JB/setup %}

For the complete nd4j-api index, consult the [Javadoc](../apidocs).

|Method| Meaning| Type |
|:----------|:-------------:| ----:|
|abs(IComplexNDArray ndarray)| Absolute value, abs(x)|Transform|
|add(IComplexNumber c)|Add two complex numbers||
|AdaGrad(int[] shape)|Vectorized Learning Rate used per Connection Weight; Create adagrad with the specified shape|Hyperparameter|
|addi(IComplexNumber c, IComplexNumber result)|Add two complex numbers in place||
|addi(IComplexNumber c)|Add two complex numbers in-place storing the result in this.||
|addi(Number a, IComplexNumber result)|Add a real component number to a complex number in place||
|applyDerivative(INDArray input)|Applies the derivative of a transform function to the param input|Activation|
|arange(double begin, double end)|Array of evenly spaced values.||
|asDouble()|Convert complex number to a double||
|asFloat()|Convert this number to a float||
|BaseComplexNDArray(float[] data, int[] shape, char ordering)|Create NDArray with given data, shape and 0 offset. The indexing scheme for a complex ndarray is 2 * length, not length (imaginary components have to be stored alongside realComponent components).||
|BaseComplexNDArray(INDArray m,char ordering)|Construct a complex matrix from a realComponent matrix.||
|BaseComplexNDArray(List<IComplexNDArray> slices,int[] shape,int[] stride,char ordering)|Create NDArray from the specified slices and the given shape||
|bernoullis(double n, double k, double successProb)|Returns the Bernoulli trial for the given event. A Bernoulli trial is a mechanism for detecting the probability of a given event occurring k times in n independent trials.||
|complexArgument()|Returns the argument of a complex number||
|cosineSim(INDArray d1, INDArray d2)|Measures the cosine of the angle between two vectors of an inner product space||
|divi(IComplexNumber c, IComplexNumber result)|Divide two complex numbers in place||
|downSample(INDArray d1, int[] stride)|Decreases the sampling rate by integer factor (stride)|Signal processing|
|eigenvalues(INDArray A)|Computes the eigenvalues of a general matrix.|
|eigenvectors(INDArray A)|Computes the eigenvalues and eigenvectors of a general matrix. For matlab users note the following from their documentation: The columns of V present eigenvectors of A. The diagonal matrix D contains eigenvalues. This is in reverse order of Matlab's eig(A) call.|
|eq(INDArray ndArray)|Binary matrix of whether the number at a given index is equal||
|euclideanDistance(double[] p, double[] q)| Returns Euclidean distance of two vectors sum(i=1,n) (q_i - p_i)^2|MathUtils|
|exp()|The e^x function|Activation|
|floor(INDArray ndArray)|Binary matrix of whether the number at a given index is greater than||
|fromString(String data, String separator)| This will take a given string and separator and convert it to an equivalent double array.||
|generateUniform(int l)| This will generate a series of uniformally distributed numbers between l (L) times.||
|getRows(int[] rindices)|Get whole rows from the passed indices.||
|gr(double a, double b)| Tests if a is greater than b.||
|hardTanh|Hard Tanh is tanh constraining input to -1 to 1|Activation|
|identity(INDArray ndArray)||Transform|
|linear()|Linear activation function, just returns the input as is|Activation|
|log(INDArray ndArray)|Log function||
|manhattanDistance(double[] p, double[] q)|This will calculate the Manhattan distance between two sets of points. The Manhattan distance is equivalent to: 1_sum_n &#124;p_i - q_i&#124;||
|max(INDArray ndArray,double max)|Max function||
|maxout()|Max out activation: max of input(i,j)|Activation|
|maxPool(INDArray input,int[] ds,boolean ignoreBorder)|Max pooling|Transform|
|mean(double[] vector)| Computes the mean for an array of doubles.||
|muli(IComplexNumber c, IComplexNumber result)|Multiply two complex numbers in place||
|neq(INDArray ndArray)|Binary matrix of whether the number at a given index is equal||
|normalizeZeroMeanAndUnitVariance (INDArray toNormalize)|Normalize data to zero mean and unit variance: substract by the mean and divide by the standard deviation||
|pool(INDArray toPool,int[] stride)|Pooled expectations|Transform|
|pow(INDArray ndArray,Number power)|Power function||
|rand(int[] shape, float min, float max, org.apache.commons.math3.random. RandomGenerator rng)|Generates a random matrix between min and max||
|randomNumberBetween(double begin, double end, org.apache.commons.math3.random. RandomGenerator rng)|Generates a random integer between the specified numbers||
|rectifiedLinear()|Rectified linear|Activation|
|roundedlinear()|Rounded linear, the output: rounded|Activation|
|sigmoid()|An s-shaped function for logistic regression|Activation|
|sign(IComplexNDArray toSign)|Signum function of this ndarray||
|sm(double a, double b)|Tests if a is smaller than b||
|softmax()|Softmax function used for multinomial classification|Activation|
|softMaxRows()|Softmax with row wise features|Activation|
|sqrt(IComplexNDArray ndArray)|Takes the square root||
|subi(IComplexNumber c, IComplexNumber result)|Subtract two complex numbers in place||
|symmetricGeneralizedEigenvalues (INDArray A)|Computes generalized eigenvalues of the problem A x = L B x.|
|symmetricGeneralizedEigenvalues (INDArray A, INDArray B)|Compute generalized eigenvalues of the problem A x = L B x.|
|tanh()|Hyperbolic tangent: a sigmoidal function|Activation|
|toDecimal(String binary)|Converts the given binary string to a decimal based integer.||
|unitVec|Scale by 1 / norm2 of the matrix||
|upSample(INDArray d, INDArray scale)|Upsampling a signal (specifically the first 2 dimensions)|Signal processing|

If you do not understand the explanation of ND4J's syntax, cannot find a definition for a method, or would like to request that a function be added, please let us know on the [ND4J Google Group](https://groups.google.com/forum/#!forum/nd4j).
