package org.wordpress.android.models;

import com.android.volley.VolleyError;
import com.wordpress.rest.RestRequest;

import org.json.JSONObject;
import org.wordpress.android.WordPress;
import org.wordpress.android.datasets.AccountTable;
import org.wordpress.android.datasets.ReaderUserTable;
import org.wordpress.android.util.AppLog;
import org.wordpress.android.util.AppLog.T;
import org.xmlrpc.android.ApiHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for managing logged in user informations.
 */
public class Account extends AccountModel {
    public void fetchAccountDetails() {
        com.wordpress.rest.RestRequest.Listener listener = new RestRequest.Listener() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                if (jsonObject != null) {
                    updateFromRestResponse(jsonObject);
                    save();

                    ReaderUserTable.addOrUpdateUser(ReaderUser.fromJson(jsonObject));
                }
            }
        };

        RestRequest.ErrorListener errorListener = new RestRequest.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                AppLog.e(T.API, volleyError);
            }
        };

        WordPress.getRestClientUtilsV1_1().get("me", listener, errorListener);
    }

    public void fetchAccountSettings(final ApiHelper.GenericCallback callback) {
        com.wordpress.rest.RestRequest.Listener listener = new RestRequest.Listener() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                if (jsonObject != null) {
                    updateAccountSettingsFromRestResponse(jsonObject);
                    save();
                    if (callback != null) {
                        callback.onSuccess();
                    }
                }
            }
        };

        RestRequest.ErrorListener errorListener = new RestRequest.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                AppLog.e(T.API, volleyError);
            }
        };

        WordPress.getRestClientUtilsV1_1().get("me/settings", listener, errorListener);
    }

    public void postAccountSettings(String firstName, String lastName, String displayName, String aboutMe, final ApiHelper.GenericCallback callback) {
        com.wordpress.rest.RestRequest.Listener listener = new RestRequest.Listener() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                if (jsonObject != null) {
                    updateAccountSettingsFromRestResponse(jsonObject);
                    save();
                    if (callback != null) {
                        callback.onSuccess();
                    }
                }
            }
        };

        RestRequest.ErrorListener errorListener = new RestRequest.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                AppLog.e(T.API, volleyError);
            }
        };

        Map<String, String> params = new HashMap<>();
        params.put("first_name", firstName);
        params.put("last_name", lastName);
        params.put("display_name", displayName);
        params.put("description", aboutMe);
        WordPress.getRestClientUtilsV1_1().post("me/settings", params, null, listener, errorListener);
    }

    public void signout() {
        init();
        save();
    }

    public void save() {
        AccountTable.save(this);
    }
}
