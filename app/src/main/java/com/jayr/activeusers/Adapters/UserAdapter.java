package com.jayr.activeusers.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jayr.activeusers.Models.Users;
import com.jayr.activeusers.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> implements Filterable {
    Context context;
    List<Users> usersList;
    List<Users>usersListAll; //contain all users without being filtered

    public UserAdapter(Context context, List<Users> usersList) {
        this.context = context;
        this.usersList = usersList;
        this.usersListAll= new ArrayList<>(usersList);//initializing the ist
    }


    public UserAdapter() {
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter= new Filter() {
        //        run on a background thread(automatically created)
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Users>filterList = new ArrayList<>();
            String searchString = charSequence.toString();

            if(searchString.isEmpty()){
                filterList.addAll(usersListAll); // shows all  if the filter is epmty
            }
            else{
                for(Users users : usersList){
                    if(users.getName().toLowerCase().contains(searchString)){
                        filterList.add(users);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values=filterList;
            return filterResults;
        }
        //run on a ui thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            usersList.clear();
            usersList.addAll((Collection<? extends Users>) results.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView,email,phoneNumber;

        public ViewHolder(View view) {
            super(view);

            textView = view.findViewById(R.id.user_details);
            email = view.findViewById(R.id.user_email);
//            phoneNumber = view.findViewById(R.id.user_phone);
        }
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
//    Users users = usersList.get(position);
        holder.textView.setText(this.usersList.get(position).getName());
//        holder.phoneNumber.setText(this.usersList.get(position).getPhone());
        holder.email.setText(this.usersList.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
