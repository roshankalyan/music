#include <stdlib.h>
#include <jni.h>
#include <discid/discid.h>

#define MAX_SIZE 512

static DiscId* aDiscId[MAX_SIZE];

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    init
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_musicbrainz_discid_LibDiscId_init
  (JNIEnv *env, jobject obj) {
	int index=-1;
	int isFound = 0;
	int i = 0;

	for (i = 0; (i < MAX_SIZE) && ( isFound == 0 ); i++) {

		if (aDiscId[i] == NULL) {
				// making new discid
				aDiscId[i] = discid_new();
				index = i;
				isFound = 1;
		}
	}

	
//	index++;
	return index;
}

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    free
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_org_musicbrainz_discid_LibDiscId_free
  (JNIEnv *env, jobject obj, jint idx) {
	// freeing discid
	discid_free( aDiscId[idx] );
	aDiscId[idx] = NULL;
}

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    read
 * Signature: (ILjava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_org_musicbrainz_discid_LibDiscId_read
  (JNIEnv *env, jobject obj, jint idx, jstring jdev) {
  jboolean result;
  const char *dev = (*env)->GetStringUTFChars(env, jdev, 0);
  result=discid_read(aDiscId[idx],dev);
  (*env)->ReleaseStringUTFChars(env,jdev, dev);
  return result;
}

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    getErrorMsg
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_musicbrainz_discid_LibDiscId_getErrorMsg
  (JNIEnv *env, jobject obj, jint idx) {
  char *result=discid_get_error_msg(aDiscId[idx]);
  return (*env)->NewStringUTF(env, result);
}

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    put
 * Signature: (III[I)Z
 */
JNIEXPORT jboolean JNICALL Java_org_musicbrainz_discid_LibDiscId_put
  (JNIEnv *env, jobject obj, jint idx, jint first, jint last, jintArray offsets) {
  jboolean result;
  jint *offsetP;
  offsetP = (*env)->GetIntArrayElements(env, offsets, NULL);
  result = discid_put(aDiscId[idx],(int)first,(int)last,(int *)offsetP);
  (*env)->ReleaseIntArrayElements(env, offsets, offsetP, 0);
  return result;
}

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    getId
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_musicbrainz_discid_LibDiscId_getId
  (JNIEnv *env, jobject obj, jint idx) {
  char *result=discid_get_id(aDiscId[idx]);
  return (*env)->NewStringUTF(env, result);
}

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    getFreeDBId
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_musicbrainz_discid_LibDiscId_getFreeDBId
  (JNIEnv *env, jobject obj, jint idx) {
  char *result=discid_get_freedb_id(aDiscId[idx]);
  return (*env)->NewStringUTF(env, result);
}

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    getSubmissionURL
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_musicbrainz_discid_LibDiscId_getSubmissionURL
  (JNIEnv *env, jobject obj, jint idx) {
  char *result=discid_get_submission_url(aDiscId[idx]);
  return (*env)->NewStringUTF(env, result);
}

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    getWebServiceURL
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_musicbrainz_discid_LibDiscId_getWebServiceURL
  (JNIEnv *env, jobject obj, jint idx) {
  char *result=discid_get_webservice_url(aDiscId[idx]);
  return (*env)->NewStringUTF(env, result);
}

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    getDefaultDevice
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_musicbrainz_discid_LibDiscId_getDefaultDevice
  (JNIEnv *env, jobject obj, jint idx) {
  char *result=discid_get_default_device();
  return (*env)->NewStringUTF(env, result);
}

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    getFirstTrackNum
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_org_musicbrainz_discid_LibDiscId_getFirstTrackNum
  (JNIEnv *env, jobject obj, jint idx) {
  return discid_get_first_track_num(aDiscId[idx]);
}

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    getLastTrackNum
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_org_musicbrainz_discid_LibDiscId_getLastTrackNum
  (JNIEnv *env, jobject obj, jint idx) {
  return discid_get_last_track_num(aDiscId[idx]);
}

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    getSectors
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_org_musicbrainz_discid_LibDiscId_getSectors
  (JNIEnv *env, jobject obj, jint idx) {
  return discid_get_sectors(aDiscId[idx]);
}

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    getTrackOffset
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_org_musicbrainz_discid_LibDiscId_getTrackOffset
  (JNIEnv *env, jobject obj, jint idx, jint trackNum) {
  return discid_get_track_offset(aDiscId[idx],trackNum);
}

/*
 * Class:     org_musicbrainz_discid_LibDiscId
 * Method:    getTrackLength
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_org_musicbrainz_discid_LibDiscId_getTrackLength
  (JNIEnv *env, jobject obj, jint idx, jint trackNum) {
  return discid_get_track_length(aDiscId[idx],trackNum);
}

