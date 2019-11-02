package com.example.prototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MessageListAdapter extends ArrayAdapter<Message> {

    private static final String TAG = "MessageListAdapter";

    private MessageListActivity parent;
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    private static class ViewHolder {
        TextView subject;
        TextView contents;
        TextView from;
        TextView to;
    }

    public MessageListAdapter(Context context, int resource, ArrayList<Message> objects, MessageListActivity parent) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        this.parent = parent;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String contents = getItem(position).getContents();
        String subject = getItem(position).getSubject();
        String to = getItem(position).getTo();
        String from = getItem(position).getFrom();

        final View result;

        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.contents = (TextView) convertView.findViewById(R.id.MessageContents);
            holder.subject = (TextView) convertView.findViewById(R.id.MessageSubject);
            holder.from = (TextView) convertView.findViewById(R.id.MessageFrom);
            holder.to = (TextView) convertView.findViewById(R.id.MessageTo);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Message message = new Message(subject, contents, from, to);

        holder.contents.setText(message.getContents());
        holder.subject.setText(message.getSubject());
        holder.from.setText("from: "+ message.getFrom());
        holder.to.setText("to:" + message.getTo());

        return convertView;
    }
}