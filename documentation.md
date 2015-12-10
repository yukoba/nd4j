---
layout: page
title: "ND4J Syntax"
description: ""
---
{% include JB/setup %}

For the complete nd4j-api index, please consult the [Javadoc](../doc).

There are three types of operations used in ND4J: scalars, transforms and accumulations. We’ll use the word op synonymously with operation. You can see the lists of those three kinds of [ND4J ops under the directories here]( https://github.com/deeplearning4j/nd4j/tree/master/nd4j-api/src/main/java/org/nd4j/linalg/api/ops/impl
). Each Java file in each list is an op. 

Most of the ops just take [enums](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html), or a list of discrete values that you can autocomplete. Activation functions are the exception, because they take strings such as `"relu"` or `"tanh"`. 

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

As you can see, there are three possible argument types with ND4J ops: inputs, optional arguments and outputs. The outputs are specified in the ops' constructor. The inputs are specified in the parentheses following the method name, always in the first position, and the optional arguments are used to transform the inputs; e.g. the scalar to add; the coefficient to multiply by, always in the second position. 

|Method| What it does |
|**Transforms**||
|ACos(INDArray x)|Trigonometric inverse cosine, elementwise. The inverse of cos such that, if `y = cos(x)`, then `x = ACos(y)`.|
|ASin(INDArray x)|Also known as arcsin. Inverse sine, elementwise.|
|ATan(INDArray x)|Trigonometric inverse tangent, elementwise. The inverse of tan, such that, if `y = tan(x)` then `x = ATan(y)`.|
|Transforms.tanh(myArray)|Hyperbolic tangent: a sigmoidal function. This applies elementwise tanh inplace.|
|Nd4j.getExecutioner().exec(Nd4j.getOpFactory().createTransform("tanh", myArray));|equivalent to the above|

|**Scalar**||
|INDArray.add(number)|Returns the result of adding `number` to each entry of `INDArray x`; e.g. myArray.add(2.0)|
|INDArray.addi(number)|Returns the result of adding `number` to each entry of `INDArray x`.|
|ScalarAdd(INDArray x, Number num)|Returns the result of adding `num` to each entry of `INDArray x`.|
|ScalarDivision(INDArray x, Number num)|Returns the result of dividing each entry of `INDArray x` by `num`.|
|ScalarMax(INDArray x, Number num)|Compares each entry of `INDArray x` to `num` and returns the higher quantity.|
|ScalarMultiplication(INDArray x, Number num)|Returns the result of multiplying each entry of `INDArray x` by `num`.|
|ScalarReverseDivision(INDArray x, Number num)|Returns the result of dividing `num` by each element of `INDArray x`.|
|ScalarReverseSubtraction(INDArray x, Number num)|Returns the result of subtracting each entry of `INDArray x` from `num`.|
|ScalarSet(INDArray x, Number num)|This sets the value of each entry of `INDArray x` to `num`.|
|ScalarSubtraction(INDArray x, Number num)|Returns the result of subtracting `num` from each entry of `INDArray x`.|


If you do not understand the explanation of ND4J's syntax, cannot find a definition for a method, or would like to request that a function be added, please let us know on [Gitter live chat](https://gitter.im/deeplearning4j/deeplearning4j).
