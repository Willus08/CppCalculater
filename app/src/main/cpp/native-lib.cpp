#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jstring

JNICALL
Java_com_helpmeproductions_willus08_cppcalculater_Calculator_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_helpmeproductions_willus08_cppcalculater_Calculator_diffFromJNI(JNIEnv *env,
                                                                         jobject instance, jdouble a,
                                                                         jdouble b) {
    double d;
    d = a - b;
    return d;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_helpmeproductions_willus08_cppcalculater_Calculator_sumFromJNI(JNIEnv *env,
                                                                        jobject instance, jdouble a,
                                                                        jdouble b) {
    double s;
    s = a + b;
    return s;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_helpmeproductions_willus08_cppcalculater_Calculator_prodFromJNI(JNIEnv *env,
                                                                         jobject instance, jdouble a,
                                                                         jdouble b) {
    double p;
    p = a * b;
    return p;

}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_helpmeproductions_willus08_cppcalculater_Calculator_quoteFromJNI(JNIEnv *env,
                                                                          jobject instance, jdouble a,
                                                                          jdouble b) {
    if(b == 0){
        return 0;
    } else{
        double q;
        q = a/b;
        return q;
    }
}