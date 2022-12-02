package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.contentcapture.ContentCaptureCondition;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserViewAdapter extends RecyclerView.Adapter<UserViewAdapter.ViewHolder> {

    private ArrayList<UserDTO> userDTOArrayList;
    private Context context;


    public UserViewAdapter (ArrayList<UserDTO> userDTOArrayList, Context context) {
        this.userDTOArrayList = userDTOArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public UserViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_customer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewAdapter.ViewHolder holder, int position) {

        // Setting data to the views of recycler view item.
        UserDTO dto = userDTOArrayList.get(position);

        holder.user_Name.setText(dto.getUserName());
        holder.user_Type.setText(dto.getUserType());
        holder.user_Email.setText(dto.getUserEmail());
        holder.user_Password.setText(dto.getUserPassword());
        holder.user_MembershipType.setText(dto.getUserMembershipType());

    }

    @Override
    public int getItemCount() {
        return userDTOArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Declaring TextView variables

        private TextView user_Name, user_Type, user_Email, user_Password, user_MembershipType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            user_Name = itemView.findViewById(R.id.idCustomerName);
            user_Type = itemView.findViewById(R.id.idUserType);
            user_Email = itemView.findViewById(R.id.idUserEmail);
            user_Password = itemView.findViewById(R.id.idUserPassword);
            user_MembershipType = itemView.findViewById(R.id.idUserMembershipType);


        }
    }
}
