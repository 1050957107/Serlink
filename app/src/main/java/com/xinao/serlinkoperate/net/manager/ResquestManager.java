package com.xinao.serlinkoperate.net.manager;


import com.xinao.serlinkoperate.base.IBaseUrl;
import com.xinao.serlinkoperate.net.server.IHomeApiServer;
import com.xinao.serlinkoperate.net.server.ILoginApiServer;
import com.xinao.serlinkoperate.net.server.IMeApiServer;
import com.xinao.serlinkoperate.net.server.IMessageApiServer;
import com.xinao.serlinkoperate.net.server.IServiceApiServer;
import com.xinao.serlinkoperate.util.LoggerUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者： Administrator on 2017/12/28 16:25.
 * 邮箱：995472572@qq.com
 * 说明: 接口管理类
 */

public class ResquestManager {
    private static final String TAG = ResquestManager.class.getName();
    private ILoginApiServer iLoginApiServer;
    private IHomeApiServer iHomeApiServer;
    private IMeApiServer iMeApiServer;
    private IServiceApiServer iServiceApiServer;
    private IMessageApiServer iMessageApiServer;

    private static class SendCodeHelper {
        private static final ResquestManager INSTANCE = new ResquestManager();
    }

    private ResquestManager() {
    }

    public static final ResquestManager getInstance() {
        return SendCodeHelper.INSTANCE;
    }

    private final OkHttpClient okHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)//上线前将此行注释掉
                .retryOnConnectionFailure(true)
                .build();
        return okClient;
    }

    /**
     * 请求拦截器，修改请求header
     */
    private class RequestInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request()
                    .newBuilder()
                    .build();
            LoggerUtils.e(TAG, "RequestInterceptor.requestComments:" + request.toString());
            LoggerUtils.e(TAG, "RequestInterceptor.requestComments headers:" + request.headers().toString());
            return chain.proceed(request);
        }
    }

    private Retrofit retrofit() {
        return new Retrofit.Builder()
                .client(okHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(IBaseUrl.BASE_URL)
                .build();
    }

    public ILoginApiServer iLoginApiServer() {
        if (iLoginApiServer == null) {
            Retrofit retrofit = retrofit();
            iLoginApiServer = retrofit.create(ILoginApiServer.class);
        }
        return iLoginApiServer;
    }


    public IMeApiServer iMeAPiServer() {
        if (iMeApiServer == null) {
            Retrofit retrofit = retrofit();
            iMeApiServer = retrofit.create(IMeApiServer.class);
        }
        return iMeApiServer;
    }

    public IHomeApiServer iHomeApiServer() {
        if (iHomeApiServer == null) {
            Retrofit retrofit = retrofit();
            iHomeApiServer = retrofit.create(IHomeApiServer.class);
        }
        return iHomeApiServer;
    }

    public IServiceApiServer iServiceApiServer() {
        if (iServiceApiServer == null) {
            Retrofit retrofit = retrofit();
            iServiceApiServer = retrofit.create(IServiceApiServer.class);
        }
        return iServiceApiServer;
    }

    public IMessageApiServer iMessageApiServer() {
        if (iMessageApiServer == null) {
            Retrofit retrofit = retrofit();
            iMessageApiServer = retrofit.create(IMessageApiServer.class);
        }
        return iMessageApiServer;
    }
}
