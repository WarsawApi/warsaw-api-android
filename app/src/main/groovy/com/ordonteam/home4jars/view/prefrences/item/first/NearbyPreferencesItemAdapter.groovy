package com.ordonteam.home4jars.view.prefrences.item.first

import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.Predictions
import com.ordonteam.home4jars.dto.preferences.NearbyPreferences
import com.ordonteam.home4jars.service.AutocompleteService
import com.ordonteam.home4jars.view.common.EmptyTextWatcher
import com.ordonteam.home4jars.view.common.item.ItemAdapter
import com.ordonteam.home4jars.view.common.item.ItemGroup
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers

import static ItemGroup.FIRST_ADDITIONAL_ROWS

@CompileStatic
@TupleConstructor
final class NearbyPreferencesItemAdapter extends ItemAdapter<Holder> {

    NearbyPreferences nearbyPreferences
    private final AutocompleteService autocompleteService = new AutocompleteService()
    private Subscription subscription

    @Override
    int getViewType() {
        return R.layout.prefrences_nearby_row
    }

    @Override
    boolean match(ItemGroup itemGroup) {
        return itemGroup == FIRST_ADDITIONAL_ROWS
    }

    @Override
    Holder onCreateViewHolder(View view) {
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(Holder holder) {
        holder.input.text = nearbyPreferences.phrase
        holder.input.requestFocus()
        holder.input.addTextChangedListener(new EmptyTextWatcher(this.&onTextChanged.rcurry(holder)))
        holder.hint1.text = ''
        holder.hint1.onClickListener = this.&onTextViveClicked.rcurry(holder.input)
        holder.hint2.text = ''
        holder.hint2.onClickListener = this.&onTextViveClicked.rcurry(holder.input)
        holder.hint3.text = ''
        holder.hint3.onClickListener = this.&onTextViveClicked.rcurry(holder.input)
    }

    void onTextChanged(String text, Holder holder) {
        nearbyPreferences.phrase = holder.input.text.toString()
        subscription?.unsubscribe()
        subscription = autocompleteService.call(text)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this.&onPredictions.rcurry(holder))
    }

    void onPredictions(Predictions predictions, Holder holder) {
        int size = predictions.predictions.size()
        holder.hint1.text = size > 0 ? predictions.predictions[0].description : ''
        holder.hint2.text = size > 1 ? predictions.predictions[1].description : ''
        holder.hint3.text = size > 2 ? predictions.predictions[2].description : ''
    }

    void onTextViveClicked(View view, EditText editText) {
        editText.text = ((TextView) view).text
    }

    final static class Holder extends RecyclerView.ViewHolder {

        EditText input
        TextView hint1
        TextView hint2
        TextView hint3

        Holder(View itemView) {
            super(itemView)
            input = (EditText) itemView.findViewById(R.id.preferences_nearby_input)
            hint1 = (TextView) itemView.findViewById(R.id.preferences_nearby_hint_1)
            hint2 = (TextView) itemView.findViewById(R.id.preferences_nearby_hint_2)
            hint3 = (TextView) itemView.findViewById(R.id.preferences_nearby_hint_3)
        }
    }
}