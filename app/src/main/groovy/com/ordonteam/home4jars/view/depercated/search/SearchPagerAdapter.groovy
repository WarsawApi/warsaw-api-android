package com.ordonteam.home4jars.view.depercated.search

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.service.SearchParams
import de.greenrobot.event.EventBus
import groovy.transform.CompileStatic

@CompileStatic
final class SearchPagerAdapter extends PagerAdapter {

    @Override
    int getCount() {
        return 2
    }

    @Override
    boolean isViewFromObject(View view, Object object) {
        return view == object
    }

    @Override
    Object instantiateItem(ViewGroup container, int position) {
        def inflater = LayoutInflater.from(container.context)
        def view = inflater.inflate(R.layout.search_options, container, false)
        view.findViewById(R.id.search).onClickListener = this.&onSearch.curry(view)
        container.addView(view)
        return view
    }

    void onSearch(View root, View view) {
        SearchParams params = new SearchParams()
        params.school = Integer.parseInt((root.findViewById(R.id.school) as TextView).text.toString())
        params.metro = Integer.parseInt((root.findViewById(R.id.metro) as TextView).text.toString())
        EventBus.default.post(new SearchEvent(params))
    }
}
