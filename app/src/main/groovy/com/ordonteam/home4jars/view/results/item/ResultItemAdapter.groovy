package com.ordonteam.home4jars.view.results.item

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.SearchResult
import com.ordonteam.home4jars.view.common.item.ItemAdapter
import com.ordonteam.home4jars.view.common.item.ItemGroup
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import static ItemGroup.RESULT

@CompileStatic
@TupleConstructor
final class ResultItemAdapter extends ItemAdapter<Holder> {

    SearchResult searchResult

    @Override
    int getViewType() {
        return R.layout.result_item
    }

    @Override
    Holder onCreateViewHolder(View view) {
        return new Holder(view)
    }

    @Override
    boolean match(ItemGroup itemGroup) {
        return itemGroup == RESULT
    }

    @Override
    void onBindViewHolder(Holder holder) {
        Glide.with(holder.itemView.context).load(searchResult.imageUrl).placeholder(R.drawable.map_marker).into(holder.imageView)
        holder.addressView.text = searchResult.address
        holder.urlView.text = searchResult.url
        holder.priceView.text = searchResult.price
        holder.itemView.onClickListener = this.&onClick
    }

    void onClick(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(searchResult.url));
        view.context.startActivity(i);
    }

    final static class Holder extends RecyclerView.ViewHolder {

        ImageView imageView
        TextView addressView
        TextView priceView
        TextView urlView

        Holder(View itemView) {
            super(itemView)
            imageView = itemView.findViewById(R.id.result_image) as ImageView
            addressView = itemView.findViewById(R.id.result_address) as TextView
            priceView = itemView.findViewById(R.id.result_price) as TextView
            urlView = itemView.findViewById(R.id.result_url) as TextView
        }
    }
}