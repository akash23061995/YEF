package yef.gwalior.aks.com.yef;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;


public class GalleryImageAdapter extends BaseAdapter
{
    private Context mContext;



    public GalleryImageAdapter(Context context)
    {
        mContext = context;
    }

    public int getCount() {
        return mImageIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }


    // Override this method according to your need
    public View getView(int index, View view, ViewGroup viewGroup)
    {
        // TODO Auto-generated method stub
        ImageView i = new ImageView(mContext);

        i.setImageResource(mImageIds[index]);
        i.setLayoutParams(new Gallery.LayoutParams(600, 400));
        i.setId(index);
        i.setScaleType(ImageView.ScaleType.FIT_XY);




        return i;
    }

    public Integer[] mImageIds = {
            R.drawable.gallery_16,
            R.drawable.gallery_2,
            R.drawable.gallery_3,
            R.drawable.gallery_4,
            R.drawable.gallery_5,
            R.drawable.gallery_6,
            R.drawable.gallery_8,
            R.drawable.gallery_10,
            R.drawable.gallery_12,
            R.drawable.gallery_13,
            R.drawable.gallery_14,
            R.drawable.gallery_15,
            R.drawable.gallery_1,
            R.drawable.product_candle4,
            R.drawable.product_candle,
            R.drawable.product_diya3,
            R.drawable.product_candle3,
            R.drawable.product_diya2,
            R.drawable.visionhome,
            R.drawable.visiondonate_land,
            R.drawable.vision2_land,
            R.drawable.vision3_land,
            R.drawable.vision4_land,
            R.drawable.product_led,


    };

}