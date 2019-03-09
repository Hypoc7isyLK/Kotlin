package com.example.rxlambda

import javax.net.ssl.*
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate

class TrustAllCerts : X509TrustManager {

    @Throws(CertificateException::class)
    override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {

    }

    @Throws(CertificateException::class)
    override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {

    }

    override fun getAcceptedIssuers(): Array<X509Certificate?> {
        return arrayOfNulls(0)
    }

    class TrustAllHostnameVerifier : HostnameVerifier {

        override fun verify(hostname: String, session: SSLSession): Boolean {
            return true
        }
    }

    companion object {

        fun createSSLSocketFactory(): SSLSocketFactory? {
            var factory: SSLSocketFactory? = null
            try {
                val context = SSLContext.getInstance("TLS")
                context.init(null, arrayOf<TrustManager>(TrustAllCerts()), SecureRandom())
                factory = context.socketFactory
            } catch (e: Exception) {
            }

            return factory
        }
    }
}
