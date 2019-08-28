package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;


public class BodyPartFragment extends Fragment {
    private static final String TAG = "BodyPartFragment";
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    private List<Integer> mImageIds;
    private int mListIndex;


    public BodyPartFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){

        if (saveInstanceState != null){
            mImageIds = saveInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = saveInstanceState.getInt(LIST_INDEX);
        }
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        if (mImageIds != null){
            imageView.setImageResource(mImageIds.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    mListIndex ++;
                    mListIndex %=  mImageIds.size();
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        }else{
            Log.v(TAG, "This Fragment has a null list of image id's");
        }

        // imageView.setImageResource(AndroidImageAssets.getHeads().get(0));

        return rootView;
    }


    public void setImageIds(List<Integer> imageIds){
        mImageIds = imageIds;
    }

    public void setListIndex(int index){
        mListIndex = index;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState){
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }
}
