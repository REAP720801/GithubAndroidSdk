package com.alorma.github.sdk.services.git;

import android.content.Context;
import com.alorma.github.sdk.bean.dto.response.GitCommit;
import com.alorma.github.sdk.bean.info.RepoInfo;
import com.alorma.github.sdk.services.client.GithubClient;
import retrofit.RestAdapter;
import rx.Observable;

public class GetGitCommitClient extends GithubClient<GitCommit> {

  private final RepoInfo info;

  public GetGitCommitClient(Context context, RepoInfo repoInfo) {
    super(context);
    this.info = repoInfo;
  }

  @Override
  protected Observable<GitCommit> getApiObservable(RestAdapter restAdapter) {
    return restAdapter.create(GitDataService.class).repoCommit(info.owner, info.name, info.branch);
  }
}
