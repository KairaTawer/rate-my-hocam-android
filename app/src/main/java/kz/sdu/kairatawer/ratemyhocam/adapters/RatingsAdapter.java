package kz.sdu.kairatawer.ratemyhocam.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import kz.sdu.kairatawer.ratemyhocam.R;
import kz.sdu.kairatawer.ratemyhocam.activities.RateTeacherActivity;
import kz.sdu.kairatawer.ratemyhocam.activities.RatingAcceptActivity;
import kz.sdu.kairatawer.ratemyhocam.activities.TeacherProfileActivity;
import kz.sdu.kairatawer.ratemyhocam.activities.ViewAllActivity;
import kz.sdu.kairatawer.ratemyhocam.models.Rating;
import kz.sdu.kairatawer.ratemyhocam.models.Teacher;

public class RatingsAdapter extends RecyclerView.Adapter<RatingAcceptActivity.RatingViewHolder> {
    ArrayList<Rating> ratings;
    Context context;

    public RatingsAdapter(Context c, ArrayList ratings) {
        this.context = c;
        this.ratings = ratings;
    }

    @NonNull
    @Override
    public RatingAcceptActivity.RatingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rating_list_item, parent, false);

        return new RatingAcceptActivity.RatingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RatingAcceptActivity.RatingViewHolder holder, final int position) {
        Rating currentRating = ratings.get(position);

        holder.setRating(String.valueOf(currentRating.getRating()));
        holder.setComment(currentRating.getComment());

    }

    @Override
    public int getItemCount() {
        return ratings.size();
    }
}
