package us.selvig.android.messier_hunter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by moya on 3/21/16.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

  protected abstract Fragment createFragment();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_catalog);

    FragmentManager fm = getSupportFragmentManager();
    Fragment fragment = fm.findFragmentById(R.id.fragment_container);

    if (fragment == null) {
      fragment = createFragment();
      fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
    }
  }
}
