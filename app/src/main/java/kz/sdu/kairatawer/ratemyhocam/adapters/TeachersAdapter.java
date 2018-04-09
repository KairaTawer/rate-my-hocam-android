package kz.sdu.kairatawer.ratemyhocam.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kz.sdu.kairatawer.ratemyhocam.R;
import kz.sdu.kairatawer.ratemyhocam.activities.TeacherProfileActivity;
import kz.sdu.kairatawer.ratemyhocam.activities.ViewAllActivity;
import kz.sdu.kairatawer.ratemyhocam.models.Teacher;

public class TeachersAdapter extends RecyclerView.Adapter<ViewAllActivity.TeacherViewHolder> {
    ArrayList<Teacher> teachers;
    Context context;

    public TeachersAdapter(Context c, ArrayList teachers) {
        this.context = c;
        this.teachers = teachers;
    }

    @NonNull
    @Override
    public ViewAllActivity.TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teacher_list_item, parent, false);

        return new ViewAllActivity.TeacherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewAllActivity.TeacherViewHolder holder, final int position) {
        holder.setName(teachers.get(position).getName());
        holder.setRating(teachers.get(position).getRating() + "");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TeacherProfileActivity.class);
                intent.putExtra("teacherId", teachers.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }
}