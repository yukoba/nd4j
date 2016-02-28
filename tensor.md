---
layout: default
title: Tensors & ND4j
---

# Tensors & ND4J

A vector, that column of numbers we feed into neural nets, is simply a subclass of a more general mathematical structure called a *tensor*. 

Tensors have a so-called [*rank*](http://mathworld.wolfram.com/TensorRank.html): a scalar, or single number, is of rank 0; a vector is rank 1; a matrix is rank 2; and entities of rank 3 and above are simply called tensors. 

It may be helpful to think of a scalar as a point, a vector as a line, a matrix as a plane, and tensors as objects of three dimensions or more. A matrix has rows and columns, two dimensions, and therefore is of rank 2. A three-dimensional tensor, such as those we use to represent color images, has channels, rows and columns, and therefore counts as rank 3. 

As mathematical objects with multiple dimensions, tensors have a shape, and we specify that shape by treating tensors as n-dimensional arrays. 

With ND4J, we do that by creating a new nd array and feeding it data, shape and order as its parameters. In pseudo code, this would be 

    nd4j.createArray(data, shape, order)

In real code, this line

    INDArray arr = Nd4j.create(new float[]{1,2,3,4},new int[]{2,2},'c');

creates an array with four elements, whose shape is 2 by 2, and whose order is "row major", or rows first, which is the default in C. (In contrast, Fortran uses "column major" ordering, and could be specified with an 'f' as the third parameter.) The distinction between thetwo orderings, for the array created above, is best illustrated with a table:

| Row-major (C) | Column-major (Fortran) | 
| :-------------: |:-------------:| 
| [1,2] | [1,3] |
| [3,4] | [2,4] |

Once we create an n-dimensional array, we may want to work with slices of it. Rather than copying the data, which is expensive, we can simply "view" muli-dimensional slices. A slice of array "a" could be defined like this:

    a[0:5,3:4,6:7]

which would give you the first 5 channels, rows 3 to 4 and columns 6 to 7, and so forth for *n* dimensions, which each individual dimension's slice starting before the colon and ending after it. 

Now, while it is useful to imagine matrices as two-dimensional planes, and 3-D tensors are cubic volumes, we store all tensors as a linear buffer. That is, they are all flattened to a row of numbers. 

For that linear buffer, we specify something called *stride*. Stride tells the computation layer how to interpret the flattened representation. It is the number of elements you skip in the buffer to get to the next channel or row or column. There's a stride for each dimension.
