package com.example.mywhatsaap.Addapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywhatsaap.Modale.User;
import com.example.mywhatsaap.R;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    @NonNull

    private ArrayList<User> list;
    private Context context;
    FirebaseAuth auth;

    public UserAdapter(@NonNull ArrayList<User> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.show_user,parent,false);
        auth = FirebaseAuth.getInstance();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user=list.get(position);
        Picasso.get().load(user.getProfilepic()).placeholder(R.drawable.ic_user).into(holder.image);
        holder.userName.setText(User.getUserName());
        holder.lastMessage.setText(User.getLastMessage());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    private ImageView image;
    private TextView userName,lastMessage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.profile_image);
            userName=itemView.findViewById(R.id.user_name);
            lastMessage=itemView.findViewById(R.id.last_msg);
        }
    }
}
