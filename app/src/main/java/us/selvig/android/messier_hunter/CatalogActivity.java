package us.selvig.android.messier_hunter;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CatalogActivity extends AppCompatActivity{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    setTheme(R.style.AppTheme);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_catalog);

    initToolbar();
    initViewPagerAndTabs();
  }

  private void initToolbar() {
    Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(mToolbar);
    setTitle(getString(R.string.app_name));
  }

  private void initViewPagerAndTabs() {
    PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
    pagerAdapter.addFragment(CatalogFragment.newInstance(), getString(R.string.catalog_name));
    pagerAdapter.addFragment(CatalogFragment.newInstance(), getString(R.string.objectives_name));

    ViewPager viewPager = (ViewPager) findViewById(R.id.activity_fragment_view_pager);
    viewPager.setAdapter(pagerAdapter);

    TabLayout tabLayout = (TabLayout) findViewById(R.id.activity_fragment_tab_layout);
    tabLayout.setupWithViewPager(viewPager);
  }

  static class PagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();

    public PagerAdapter(FragmentManager fragmentManager) {
      super(fragmentManager);
    }

    public void addFragment(Fragment fragment, String title) {
      fragmentList.add(fragment);
      fragmentTitleList.add(title);
    }

    @Override
    public Fragment getItem(int position) {
      return fragmentList.get(position);
    }

    @Override
    public int getCount() {
      return fragmentList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
      return fragmentTitleList.get(position);
    }
  }
}

