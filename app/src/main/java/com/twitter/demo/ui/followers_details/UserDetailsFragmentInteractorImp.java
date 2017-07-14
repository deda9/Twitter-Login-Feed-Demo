package com.twitter.demo.ui.followers_details;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.twitter.demo.utilities.SharedPrefUtilis;
import com.twitter.sdk.android.tweetui.UserTimeline;

import java.lang.ref.WeakReference;

/**
 * Created by Bassem Qoulta (Deda) on  7/10/17.
 * Bassem.Qoulta@gmail.com
 * Basem083926@feng.bu.edu.eg
 * +201225361630
 */

public class UserDetailsFragmentInteractorImp implements UserDetailsFragmentInteractor {

    private WeakReference<Context> weakReference;

    public UserDetailsFragmentInteractorImp(Context context) {
        this.weakReference = new WeakReference<>(context);
    }

    @Override
    public void saveLoggedUserTweets(UserTimeline userTimeline) {
        String userTimelineString = new Gson().toJson(userTimeline);

        /**
         *
         * TODO:: this part need refactor in the next phase
         * cause the object of realm need to extend RealmObject to save it
         * cuase UserTimeline is not public object so, we need some time to do this
         *
         * so fast & dirty way save this in shared
         * But NOTE,
         * It may produce Out of memory Error
         *
         */

        try{
            SharedPrefUtilis.saveLoggedUserTimeLine(this.weakReference.get(), userTimelineString);
        }catch (OutOfMemoryError error){
            Log.e("UserDetailsFragmet", "OutOfMemoryError while save TimeLine for user");
        }

    }
}
