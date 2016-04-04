package us.selvig.android.messier_hunter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by moya on 3/24/16.
 */
public class CatalogFragment extends Fragment {

  private CatalogAdapter mAdapter;
  private RecyclerView mRecyclerView;
  private List<MessierObject> mCatalog;

  public static CatalogFragment newInstance() {
    return new CatalogFragment();
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_catalog, container, false);
    initRecyclerView(mRecyclerView);
    updateUI();

    return mRecyclerView;
  }

  @Override public void onResume() {
    super.onResume();
    updateUI();
  }

  @Override public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    inflater.inflate(R.menu.menu_fragment_catalog, menu);
  }

  private void initRecyclerView(RecyclerView recyclerView) {
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    CatalogAdapter recyclerAdapter = new CatalogAdapter(mCatalog);
    recyclerView.setAdapter(recyclerAdapter);
  }

  private void updateUI() {
    mCatalog = MessierCatalog.getInstance(getActivity()).getCatalog();

    if (mAdapter == null) {
      mAdapter = new CatalogAdapter(mCatalog);
      mRecyclerView.setAdapter(mAdapter);
    } else {
      mAdapter.notifyDataSetChanged(); // TODO: find specific changes...this should only be last resort
    }
  }

  private class CatalogHolder extends RecyclerView.ViewHolder {

    private MessierObject mMessierObject;
    private TextView mName;
    private TextView mType;

    public CatalogHolder(View itemView) {
      super(itemView);
      mName = (TextView) itemView.findViewById(R.id.list_item_catalog_name);
      mType= (TextView) itemView.findViewById(R.id.list_item_catalog_type);
    }

    private void bindMessierObject(MessierObject messierObject) {
      mMessierObject = messierObject;
      mName.setText(mMessierObject.getName());
      mType.setText(mMessierObject.getType());
    }
  }

  private class CatalogAdapter extends RecyclerView.Adapter<CatalogHolder> {

    private List<MessierObject> mObjects;

    public CatalogAdapter(List<MessierObject> objects) {
      mObjects = objects;
    }

    @Override public CatalogHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater inflater = LayoutInflater.from(getActivity());
      View view = inflater.inflate(R.layout.list_item_catalog, parent, false);
      return new CatalogHolder(view);
    }

    @Override public void onBindViewHolder(CatalogHolder holder, int position) {
      MessierObject messierObject = mObjects.get(position);
      holder.bindMessierObject(messierObject);
    }

    @Override public int getItemCount() {
      return mObjects.size();
    }
  }

}

