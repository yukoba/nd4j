---
layout: page
title: "Functions"
description: ""
---
{% include JB/setup %}

|Method| What it does |
|:----------------|:-------------:|
|**Transforms**||
|ACos(INDArray x)|Trigonometric inverse cosine, elementwise. The inverse of cos such that, if `y = cos(x)`, then `x = ACos(y)`.|
|ASin(INDArray x)|Also known as arcsin. Inverse sine, element-wise.|
|ATan(INDArray x)|Trigonometric inverse tangent, elementwise. The inverse of tan, such that, if `y = tan(x)` then `x = arctan(y)`.|
|**Scalar**||
|ScalarAdd(INDArray x, Number num)|Returns the result of adding `num` to each entry of `INDArray x`.|
|ScalarDivision(INDArray x, Number num)|Returns the result of dividing each entry of `INDArray x` by `num`.|
|ScalarMax(INDArray x, Number num)|Compares each entry of `INDArray x` to `num` and returns the higher quantity.|
|ScalarMultiplication(INDArray x, Number num)|Returns the result of multiplying each entry of `INDArray x` by `num`.|
|ScalarReverseDivision(INDArray x, Number num)|Returns the result of dividing `num` by each element of `INDArray x`.|
|ScalarReverseSubtraction(INDArray x, Number num)|Returns the result of subtracting each entry of `INDArray x` from `num`.|
|ScalarSet(INDArray x, Number num)|This sets the value of each entry of `INDArray x` to `num`.|
|ScalarSubtraction(INDArray x, Number num)|Returns the result of subtracting `num` from each entry of `INDArray x`.|
|**Accumulations/Reductions**||
|||
