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
JNIEXPORT jint JNICALL
Java_com_helpmeproductions_willus08_cppcalculater_Calculator_diffFromJNI(JNIEnv *env,
                                                                         jobject instance, jint a,
                                                                         jint b) {
    int d;
    d = a - b;
    return d;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_helpmeproductions_willus08_cppcalculater_Calculator_sumFromJNI(JNIEnv *env,
                                                                        jobject instance, jint a,
                                                                        jint b) {
    int s;
    s = a + b;
    return s;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_helpmeproductions_willus08_cppcalculater_Calculator_prodFromJNI(JNIEnv *env,
                                                                         jobject instance, jint a,
                                                                         jint b) {
    int p;
    p = a * b;
    return p;

}

extern "C"
JNIEXPORT jint JNICALL
Java_com_helpmeproductions_willus08_cppcalculater_Calculator_quoteFromJNI(JNIEnv *env,
                                                                          jobject instance, jint a,
                                                                          jint b) {
    if(b == 0){
        return 0;
    } else{
        int q;
        q = a/b;
        return q;
    }
}