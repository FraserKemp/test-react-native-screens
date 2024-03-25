package com.rnscreentest;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactRootView;

public class MainActivity extends ReactActivity {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "RNScreenTest";
  }

  /**
   * Returns the instance of the {@link ReactActivityDelegate}. There the RootView is created and
   * you can specify the rendered you wish to use (Fabric or the older renderer).
   */
  @Override
  protected ReactActivityDelegate createReactActivityDelegate() {
    return new MainActivityDelegate(this, getMainComponentName());
  }

      //react-native-screens override
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(null);
      }

  public static class MainActivityDelegate extends ReactActivityDelegate {
    public MainActivityDelegate(ReactActivity activity, String mainComponentName) {
      super(activity, mainComponentName);
    }

/*
   React Native screens crash fix -> https://github.com/software-mansion/react-native-screens#android
   On Android the View state is not persisted consistently across Activity restarts, which can lead to crashes in those cases.
   It is recommended to override the native Android method called on Activity restarts in your main Activity, to avoid these crashes.
  */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(null);
}

    @Override
    protected ReactRootView createRootView() {
      ReactRootView reactRootView = new ReactRootView(getContext());
      // If you opted-in for the New Architecture, we enable the Fabric Renderer.
      reactRootView.setIsFabric(BuildConfig.IS_NEW_ARCHITECTURE_ENABLED);
      return reactRootView;
    }
  }
}
