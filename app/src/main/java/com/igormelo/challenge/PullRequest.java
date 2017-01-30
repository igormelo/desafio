package com.igormelo.challenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.igormelo.challenge.Adapters.PullRequestAdapter;
import com.igormelo.challenge.Models.PullRequests.Response;
import com.igormelo.challenge.Repo;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by root on 27/01/17.
 */

public class PullRequest extends AppCompatActivity {
    private PullRequestAdapter adapter;
    private List<Response> PullRequests = new ArrayList<>();
    private int page = 1;
    private String repo;
    private String creator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
