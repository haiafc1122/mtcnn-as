cmake_minimum_required(VERSION 3.4.1)

#include header file directory
include_directories(src/main/cpp/include
                    src/main/cpp/)

#source directory
file(GLOB MTCNN_SRC src/main/cpp/*.h
                    src/main/cpp/*.cpp)
set(MTCNN_COMPILE_CODE ${MTCNN_SRC})


#Add ncnn library
add_library(libncnn STATIC IMPORTED )
set_target_properties(libncnn
  PROPERTIES IMPORTED_LOCATION
  ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libncnn.a)

#Compile as a dynamic library
add_library(mtcnn SHARED ${MTCNN_COMPILE_CODE})

#Add the libraries that the project depends on
find_library(  log-lib log )
target_link_libraries( mtcnn
                       libncnn
                       jnigraphics
                       z
                       android
                       ${log-lib} )
