package com.example.mytestme;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final ArrayList<Item> items;

    public MyAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0){
            return new NoteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));
        }else if (viewType == 1){
            return new NoteContentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_content,parent,false));
        }else {
            return new NoteCheckViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_check,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == 0){
            Note note =(Note) items.get(position).getObject();
            ((NoteViewHolder) holder).setNote(note);
        }else if (getItemViewType(position) == 1){
            NoteContent noteContent = (NoteContent) items.get(position).getObject();
            ((NoteContentViewHolder)holder).setNoteContent(noteContent);
        }else {
            NoteCheck noteCheck = (NoteCheck) items.get(position).getObject();
            ((NoteCheckViewHolder)holder).setNoteCheck(noteCheck);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView title ,suTitle;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewTitle);
            suTitle = itemView.findViewById(R.id.textView_subTitle);
        }
        void setNote(Note note){
            title.setText(note.getTitle());
            suTitle.setText(note.getSubTitle());
        }
    }
    public static class NoteContentViewHolder extends RecyclerView.ViewHolder {

        TextView titleContent ,subTitleContent,content;
        public NoteContentViewHolder(@NonNull View itemView) {
            super(itemView);
            titleContent = itemView.findViewById(R.id.textViewTitleContent);
            subTitleContent = itemView.findViewById(R.id.textViewSubTitleContent);
            content = itemView.findViewById(R.id.textViewContent);
        }
        void setNoteContent(NoteContent noteContent){
            titleContent.setText(noteContent.getTitle());
            subTitleContent.setText(noteContent.getSubTitle());
            content.setText(noteContent.getContent());
        }
    }
    public static class NoteCheckViewHolder extends RecyclerView.ViewHolder {

        TextView checkText;
        CheckBox checkBox;
        public NoteCheckViewHolder(@NonNull View itemView) {
            super(itemView);
            checkText = itemView.findViewById(R.id.textViewCheck);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
        void setNoteCheck(NoteCheck noteCheck){
            checkText.setText(noteCheck.getTitle());
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (checkBox.isChecked()) {
                    checkText.setPaintFlags(checkText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else  {
                    checkText.setPaintFlags(checkText.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            });
        }
    }
}
