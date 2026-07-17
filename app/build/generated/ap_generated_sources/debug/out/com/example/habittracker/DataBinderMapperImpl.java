package com.example.habittracker;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.habittracker.databinding.FragmentDashboardBindingImpl;
import com.example.habittracker.databinding.FragmentEditHabitBindingImpl;
import com.example.habittracker.databinding.ItemHabitBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTDASHBOARD = 1;

  private static final int LAYOUT_FRAGMENTEDITHABIT = 2;

  private static final int LAYOUT_ITEMHABIT = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.habittracker.R.layout.fragment_dashboard, LAYOUT_FRAGMENTDASHBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.habittracker.R.layout.fragment_edit_habit, LAYOUT_FRAGMENTEDITHABIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.habittracker.R.layout.item_habit, LAYOUT_ITEMHABIT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTDASHBOARD: {
          if ("layout/fragment_dashboard_0".equals(tag)) {
            return new FragmentDashboardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_dashboard is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTEDITHABIT: {
          if ("layout/fragment_edit_habit_0".equals(tag)) {
            return new FragmentEditHabitBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_edit_habit is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMHABIT: {
          if ("layout/item_habit_0".equals(tag)) {
            return new ItemHabitBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_habit is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/fragment_dashboard_0", com.example.habittracker.R.layout.fragment_dashboard);
      sKeys.put("layout/fragment_edit_habit_0", com.example.habittracker.R.layout.fragment_edit_habit);
      sKeys.put("layout/item_habit_0", com.example.habittracker.R.layout.item_habit);
    }
  }
}
