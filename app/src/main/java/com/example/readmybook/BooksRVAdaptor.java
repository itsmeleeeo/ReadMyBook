package com.example.readmybook;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class BooksRVAdaptor extends RecyclerView.Adapter<BooksRVAdaptor.ViewHolder> {
    // variable for our array list and context
    private ArrayList<CourseModal> BooksModalArrayList;
    private Context context;

    // constructor
    public BooksRVAdaptor(ArrayList<CourseModal> BooksModalArrayList, Context context) {
        this.BooksModalArrayList = BooksModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        CourseModal modal = BooksModalArrayList.get(position);
        holder.BooksNameTV.setText(modal.getbooktitle());
        holder.BooksDescTV.setText(modal.getauthor());
        holder.BooksDurationTV.setText(modal.getisbn());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return BooksModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView BooksNameTV, BooksDescTV, BooksDurationTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            BooksNameTV = itemView.findViewById(R.id.idTVCourseName);
            BooksDescTV = itemView.findViewById(R.id.idTVCourseDuration);
            BooksDurationTV = itemView.findViewById(R.id.idTVCourseTracks);

        }
    }
}
