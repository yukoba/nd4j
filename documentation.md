---
layout: page
title: "About"
description: ""
---
{% include JB/setup %}

|Method| Meaning| Type |
|:----------|:-------------:| ----:|
|abs(IComplexNDArray ndarray)| abs(x)|
|applyDerivative(INDArray input)|Applies the derivative of a transform function to the param input|
|cosineSim||
|downSample(INDArray d1, int[] stride)|Decreases the sampling rate by integer factor (stride)|
|eigenvalues(INDArray A)|Computes the eigenvalues of a general matrix.|
|eigenvectors(INDArray A)|Computes the eigenvalues and eigenvectors of a general matrix. For matlab users note the following from their documentation: The columns of V present eigenvectors of A. The diagonal matrix D contains eigenvalues. This is in reverse order of Matlab's eig(A) call.|
|identity||
|symmetricGeneralizedEigenvalues(INDArray A)|Computes generalized eigenvalues of the problem A x = L B x.|
|symmetricGeneralizedEigenvalues(INDArray A, INDArray B)|Compute generalized eigenvalues of the problem A x = L B x.|
|unitVec||
