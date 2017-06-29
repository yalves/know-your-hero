package com.example.yanal.knowyourhero.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yanal.knowyourhero.Models.yaMarvelCharacter;
import com.example.yanal.knowyourhero.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by yanal on 28-Jun-17.
 */

public class yaMarvelCharacterAdapter extends ArrayAdapter<yaMarvelCharacter>
{
    private List<yaMarvelCharacter> characters;
    private Context context;

    public yaMarvelCharacterAdapter(List<yaMarvelCharacter> characterList, Context context)
    {
        super(context, R.layout.layout_ya_list, R.id.lstCharacters, characterList);
        this.characters = characterList;
        this.context = context;
    }

    public int getCount()
    {
        if (characters != null)
            return characters.size();
        return 0;
    }

    public yaMarvelCharacter getItem(int position)
    {
        if (characters != null)
            return characters.get(position);
        return null;
    }

    public long getItemId(int position)
    {
        if(characters != null)
            return characters.get(position).hashCode();
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_ya_list, null);
        }

        yaMarvelCharacter character = characters.get(position);
        TextView t1 = (TextView) view.findViewById(R.id.txtNameList);
        t1.setText(character.getName());

        ImageView imageView = (ImageView) view.findViewById(R.id.imgAvatarList);
        Picasso.with(context)
                .load(character.getSmallThumbnailUrl())
                .resize(200, 200)
                .into(imageView);

        return view;
    }

    public List<yaMarvelCharacter> getCharacterList()
    {
        return characters;
    }

    public void setItemList(List<yaMarvelCharacter> userList)
    {
        this.characters = userList;
    }
}
