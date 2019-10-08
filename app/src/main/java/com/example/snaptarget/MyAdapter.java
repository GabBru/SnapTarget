package com.example.snaptarget;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final List<Pair<String, String>> characters = Arrays.asList(
            Pair.create("Lyra Belacqua", " 8"),
            Pair.create("Pantalaimon", " 34"),
            Pair.create("Roger Parslow", " 345"),
            Pair.create("Lord Asriel", " 234"),
            Pair.create("Marisa Coulter", " 654"),
            Pair.create("Iorek Byrnison", " 098"),
            Pair.create("Serafina Pekkala", " 45."),
            Pair.create("Lee Scoresby", " 567"),
            Pair.create("Ma Costa", " 9878"),
            Pair.create("John Faa", " 456"),
            Pair.create("Lyra Belacqua", " 8"),
            Pair.create("Pantalaimon", " 34"),
            Pair.create("Roger Parslow", " 345"),
            Pair.create("Lord Asriel", " 234"),
            Pair.create("Marisa Coulter", " 654"),
            Pair.create("Iorek Byrnison", " 098"),
            Pair.create("Serafina Pekkala", " 45."),
            Pair.create("Lee Scoresby", " 567"),
            Pair.create("Ma Costa", " 9878"),
            Pair.create("John Faa", " 456"),
            Pair.create("Lyra Belacqua", " 8"),
            Pair.create("Pantalaimon", " 34"),
            Pair.create("Roger Parslow", " 345"),
            Pair.create("Lord Asriel", " 234"),
            Pair.create("Marisa Coulter", " 654"),
            Pair.create("Iorek Byrnison", " 098"),
            Pair.create("Serafina Pekkala", " 45."),
            Pair.create("Lee Scoresby", " 567"),
            Pair.create("Ma Costa", " 9878"),
            Pair.create("John Faa", " 456"),
            Pair.create("Lyra Belacqua", " 8"),
            Pair.create("Pantalaimon", " 34"),
            Pair.create("Roger Parslow", " 345"),
            Pair.create("Lord Asriel", " 234"),
            Pair.create("Marisa Coulter", " 654"),
            Pair.create("Iorek Byrnison", " 098"),
            Pair.create("Serafina Pekkala", " 45."),
            Pair.create("Lee Scoresby", " 567"),
            Pair.create("Ma Costa", " 9878"),
            Pair.create("John Faa", " 456")
    );

    @Override
    public int getItemCount() {
        return characters.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        System.out.println("bind ");
        Pair<String, String> pair = characters.get(position);
        holder.display(pair);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView description;

        private Pair<String, String> currentPair;

        public MyViewHolder(final View itemView) {
            super(itemView);

            name = (itemView.findViewById(R.id.tvName));
            description = (itemView.findViewById(R.id.tvRow));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(currentPair.first)
                            .setMessage(currentPair.second)
                            .show();
                }
            });
        }

        public void display(Pair<String, String> pair) {
            currentPair = pair;
            name.setText(pair.first);
            description.setText(pair.second);
        }
    }

}