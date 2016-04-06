
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

public class Frg_Terms extends Fragment {
	private transient View frgView;

	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
			final Bundle savedInstanceState) {
		frgView = inflater.inflate(R.layout.frg_web, container, false);

		initView();

		webView.loadUrl("https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/");
		webView.loadUrl("https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/&mo=AR");
		webView.loadUrl("https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/&mo=VR");
		
		return frgView;
	}
	
	private transient FrameLayout layoutWeb;
	private transient WebView webView;
	private transient ProgressBar progressBar;

	private final void setProgress(final int value) {
		if (null == progressBar) {
			progressBar = (ProgressBar) frgView.findViewById(R.id.progressBar1);
			progressBar.setMax(100);
			progressBar.setProgress(0);
		}
		if (value == 100 || value == 0) {
			progressBar.setVisibility(View.GONE);
		} else {
			progressBar.setVisibility(View.VISIBLE);
			progressBar.setProgress(value);
		}
	}

	private final void initView() {
		layoutWeb = (FrameLayout) frgView.findViewById(R.id.layoutWeb);

		if (null != webView) {
			webView.destroy();
			layoutWeb.removeAllViews();
		}
		webView = new WebView(getActivity());
		layoutWeb.addView(webView);
		webView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(final WebView view, final int progress) {
				setProgress(progress);
			}
		});
		webView.setBackgroundColor(0x00000000);
		webView.requestFocus(View.FOCUS_DOWN);
		webView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(final View view, final MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_UP) {
					if (!view.hasFocus()) {
						view.requestFocus();
					}
					view.performClick();
				}
				return false;
			}
		});
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
				view.loadUrl(url);
				return true;
			}

			@Override
			public void onPageFinished(final WebView view, final String url) {
				view.clearCache(true);
			}
		});
		webView.setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(final View view, final int keyCode, final KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					final WebView webView = (WebView) view;

					if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
						webView.goBack();
						return true;
					}
				}
				return false;
			}
		});
	}

	@Override
	public void onDestroy() {
		if (null != layoutWeb) {
			webView.destroy();
			layoutWeb.removeAllViews();
		}
		super.onDestroy();
	}
}
