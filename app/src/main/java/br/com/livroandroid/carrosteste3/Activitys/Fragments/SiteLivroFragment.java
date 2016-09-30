package br.com.livroandroid.carrosteste3.Activitys.Fragments;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import br.com.livroandroid.carrosteste3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiteLivroFragment extends BaseFragment {

    private static final String URL_SOBRE = "http://www.livroandroid.com.br/sobre.htm";
    private WebView webview;
    private ProgressBar progress;
    protected SwipeRefreshLayout swipeLayout;
    public SiteLivroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_site_livro, container, false);
        webview = (WebView) view.findViewById(R.id.webview);
        progress = (ProgressBar) view.findViewById(R.id.progress);
        swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeToRefresh);
        swipeLayout.setOnRefreshListener(OnRefreshL());
        swipeLayout.setColorSchemeResources(
                R.color.progress_1,
                R.color.progress_2,
                R.color.progress_3);
        setWebViewClient(webview);
        webview.loadUrl(URL_SOBRE);
        return  view;

    }

    private SwipeRefreshLayout.OnRefreshListener OnRefreshL() {
        return new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
              webview.reload();
            }
        };
    }

    private void setWebViewClient(WebView webview) {
        webview.setWebViewClient( new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progress.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progress.setVisibility(View.INVISIBLE);
                swipeLayout.setRefreshing(false);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if(URL_SOBRE != null && URL_SOBRE.endsWith("sobre.htm") ) {
                    AboutDialog.showAbout(getFragmentManager());
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }

}
