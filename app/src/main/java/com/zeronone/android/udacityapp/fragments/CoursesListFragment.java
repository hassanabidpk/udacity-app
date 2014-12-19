package com.zeronone.android.udacityapp.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.image.SmartImageView;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zeronone.android.udacityapp.R;
import com.zeronone.android.udacityapp.models.Course;
import com.zeronone.android.udacityapp.network.UdacityRestClass;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zeronone on 12/18/14.
 *
 * A CoursesList fragment containing a simple view.
 */
public class CoursesListFragment extends Fragment {

    private static final String LOG_TAG = "CourseListFragment";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    private ArrayList<Course> mAllCourses;

    public CoursesListFragment() {
        mAllCourses = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_courses_list, container, false);

        mAllCourses = new ArrayList<Course>();
        //Course one = new Course();
        //one.setShortSummary("Hello");
        //mAllCourses.add(one);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycle_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(false);
        mAdapter = new CourseAdapter(mAllCourses);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        // TODO: Move to a separate function and create Refresh Menu Item
        // TODO: Create RecycleView and Adapter Class for Course[]
        // TODO: Create Each Card Layout
        // TODO: Create Refresh Animation

        OkHttpClient client = new OkHttpClient();


//
        try {
            UdacityRestClassUsage clientClass = new UdacityRestClassUsage();
           run(UdacityRestClass.getAbsoluteUrl("courses"), client);

//          client.getAllCourses();
//
//
        } catch (IOException e) {
            Log.e(LOG_TAG, "Json Error Occurred");

        }

        return rootView;
    }

    private void run(String url, OkHttpClient client) throws IOException {

        new FetchWeatherTask().execute(client);

    }

    public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

        private static final String LOG_TAG = "CourseAdapter";
        private ArrayList<Course> allCourses;

        // Inner ViewHolder Class
        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView mTextView;
            public SmartImageView mImageView;

            public ViewHolder(View itemView) {
                super(itemView);
                mImageView = (SmartImageView) itemView.findViewById(R.id.course_image);
                mTextView = (TextView) itemView.findViewById(R.id.course_title_text);
            }
        }

        // Constructor
        public CourseAdapter(ArrayList<Course> allCourses) {
            this.allCourses = allCourses;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

            View v = LayoutInflater.from(viewGroup.getContext())
                                   .inflate(R.layout.card_course, viewGroup, false);


            ViewHolder vh = new ViewHolder(v);
            Log.d(LOG_TAG, "CourseAdapter#onCreateViewHolder");

            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            Course currCourse = allCourses.get(i);
            viewHolder.mImageView.setImageUrl(currCourse.getImage());
            viewHolder.mTextView.setText(currCourse.getTitle());
            Log.d(LOG_TAG, "CourseAdapter#onBindViewHolder  : Image URL :  " + currCourse.getImage());
        }

        @Override
        public int getItemCount() {
            return allCourses.size();
        }

        @Override
        public boolean equals(Object o) {
            return super.equals(o);
        }

    }

    // Get all the courses and update the view
    public class UdacityRestClassUsage {

        private static final String LOG_TAG = "UdacityRestClassUsage";

        public void getAllCourses() throws JSONException {

            UdacityRestClass.allCourses("courses", null, new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    final String kCourses = "courses";

                    try {
                        JSONArray courses = response.getJSONArray(kCourses);
                        GsonBuilder builder = new GsonBuilder();
                        builder = builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
                        Gson gson = builder.create();


                        mAllCourses = new ArrayList<Course>(Arrays.asList(gson.fromJson(courses.toString(), Course[].class)));

                        mAdapter = new CourseAdapter(mAllCourses);
                        mRecyclerView.setAdapter(mAdapter);
                        //mAdapter.notifyDataSetChanged();



                        //TextView txtView = (TextView) getActivity().findViewById(R.id.main_text);
                        //txtView.setText(allCourses[1].getShortSummary());

                        Log.d(LOG_TAG, courses.toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


            });

        }
    }

    public class FetchWeatherTask extends AsyncTask<OkHttpClient,Void,String> {

        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(OkHttpClient... params) {

            publishProgress();
            Request request = new Request.Builder()
                    .url(UdacityRestClass.getAbsoluteUrl("courses"))
                    .build();
            try {
                Response response = params[0].newCall(request).execute();

                Log.d(LOG_TAG,"response : " + response);
                return response.body().string();

            }catch (IOException e) {

                return null;
            }



        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Fetching data from Udacity!");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(true);
            progressDialog.setIndeterminate(true);
            progressDialog.show();

        }

        @Override
        protected void onPostExecute(String s) {

            progressDialog.dismiss();

            if(s != null) {

                try {
                    JSONObject response = new JSONObject(s);
                    JSONArray courses = response.getJSONArray("courses");
                    GsonBuilder builder = new GsonBuilder();
                    builder = builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
                    Gson gson = builder.create();


                    mAllCourses = new ArrayList<Course>(Arrays.asList(gson.fromJson(courses.toString(), Course[].class)));

                    mAdapter = new CourseAdapter(mAllCourses);
                    mRecyclerView.setAdapter(mAdapter);
                    //mAdapter.notifyDataSetChanged();



                    //TextView txtView = (TextView) getActivity().findViewById(R.id.main_text);
                    //txtView.setText(allCourses[1].getShortSummary());

                    Log.d(LOG_TAG, courses.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            super.onPostExecute(s);
        }
    }


}