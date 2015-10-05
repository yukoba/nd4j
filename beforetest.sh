#!/bin/bash
git clone https://github.com/xianyi/OpenBLAS
cd OpenBLAS
make
sudo make install
sudo ln -s /opt/OpenBLAS/lib/libopenblas_haswellp-r0.2.14.so /usr/lib64/libblas.so.3
sudo ln -s /opt/OpenBLAS/lib/libopenblas_haswellp-r0.2.14.so /usr/lib64/liblapack.so.3