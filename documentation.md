---
layout: page
title: "ND4J Syntax"
description: ""
---
{% include JB/setup %}

For the complete nd4j-api index, please consult the [Javadoc](../doc).

There are three types of operations used in ND4J: scalars, transforms and accumulations. We’ll use the word op synonymously with operation. You can see the lists of those three kinds of [ND4J ops under the directories here]( https://github.com/deeplearning4j/nd4j/tree/master/nd4j-api/src/main/java/org/nd4j/linalg/api/ops/impl
). Each Java file in each list is an op. 

Most of the ops just take [enums] (https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html), or a list of discrete values that you can autocomplete. Activation functions are the exception, because they take strings such as `"relu"` or `"tanh"`. 

Scalars, transforms and accumulations each have their own patterns. Transforms are the simplest, since the take a single argument and perform an operation on it. Absolute value is a transform that takes the argument `x` like so `abs(IComplexNDArray ndarray)` and produces the result which is the absolute value of x. Similarly, you would apply to the sigmoid transform `sigmoid()` to produce the "sigmoid of x".

Scalars just take two arguments: the input and the scalar to be applied to that input. For example, `ScalarAdd()` takes two arguments: the input `INDArray x` and the scalar `Number num`; i.e. `ScalarAdd(INDArray x, Number num)`. The same format applies to every Scalar op. 

Finally, we have accumulations, which are also known as reductions in GPU-land. Accumulations add arrays and vectors to one another and can *reduce* the dimensions of those arrays in the result by adding their elements in a rowwise op. For example, we might run an accumulation on the array 

     [1 2
      3 4]

Which would give us the vector

     [3
      7]

Reducing the columns (i.e. dimensions) from two to one.

Accumulations can be either pairwise or scalar. In a pairwise reduction, we might be dealing with two arrays, x and y, which have the same shape. In that case, we could calculate the cosine similarity of x and y by taking their elements two by two. 

        cosineSim(x[i], y[i])

Or take `EuclideanDistance(arr, arr2)`, a reduction between one array `arr` and another `arr2`.

Many ND4J ops are overloaded, meaning methods sharing a common name have different argument lists. Below we will explain only the simplest configurations.

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
