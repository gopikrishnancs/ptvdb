package com.android.ptvdb.data.datasource.network

import java.io.IOException
import java.io.InputStream
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.util.Scanner
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkClient @Inject constructor() {

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response, null if no response
     * @throws IOException Related to network and stream reading
     */
    fun getResponseFromHttpUrl(
        url: URL
    ): String {
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        urlConnection.setRequestProperty("accept", "application/json")
        urlConnection.setRequestProperty("Authorization:", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMjllM2IyYjNiYjk2Y2EyZGU2NTg2MmQ4NmRkYjIyZSIsInN1YiI6IjY1NzQ2N2FiYTg0YTQ3MDExYjVmZTcwOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dnW2JN2mDe2GMRoB-QksmG8Lh_DayFe0Bu7jLcIIbCA")

        return try {
            val stream: InputStream = urlConnection.inputStream
            val scanner = Scanner(stream)
            scanner.useDelimiter("\\A")
            val hasInput: Boolean = scanner.hasNext()
            var response = ""
            if (hasInput) {
                response = scanner.next()
            }
            scanner.close()
            response
        } catch (e: Exception) {
            ""
        } finally {
            urlConnection.disconnect()
        }
    }
}