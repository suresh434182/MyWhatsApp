package com.example.mywhatsaap.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mywhatsaap.Addapters.UserAdapter;
import com.example.mywhatsaap.Modale.User;
import com.example.mywhatsaap.R;
import com.example.mywhatsaap.databinding.FragmentBlankChatsBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;
import java.util.ArrayList;


public class BlankFragmentChatsFragment extends Fragment {
    FragmentBlankChatsBinding binding;


    public BlankFragmentChatsFragment()
    {

    }
    ArrayList<User>list=new ArrayList<>();
    FirebaseDatabase database;
    private DatabaseReference databaseReference;
    FirebaseAuth auth;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_chats,container,false);
        recyclerView=view.findViewById(R.id.chatRecyer);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        UserAdapter adapter = new UserAdapter(list,getContext());
        recyclerView.setAdapter(adapter);
        //getUser();
        database=FirebaseDatabase.getInstance();
       databaseReference=database.getReference();
              databaseReference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                list.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    User t = new User();

                    Log.e("The read success: ", "suooo" + list.size());
                    t.setUserName(snapshot.child("userName").getValue().toString());

                    list.add(t);

                }

                adapter.notifyDataSetChanged();

                Log.e("The read success: ", "su" + list.size());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Log.e("The read failed: ", databaseError.getMessage());


            }
        });

        return view;
    }


}
