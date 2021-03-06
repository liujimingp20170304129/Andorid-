package com.example.rememberwords;

import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;


public class LayoutAdapter extends ListAdapter<Word, LayoutAdapter.LayoutViewHolder> {

    private boolean useCardView;
    private WordViewModel wordViewModel;

    LayoutAdapter(boolean useCardView, WordViewModel wordViewModel) {
        super(new DiffUtil.ItemCallback<Word>() {
            //比较列表中的两个元素是否相同
            @Override
            public boolean areItemsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
                return oldItem.getId() == newItem.getId();
            }

            //比较列表中内容是否相同
            @Override
            public boolean areContentsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
                return (oldItem.getWord().equals(newItem.getWord())
                        && oldItem.getChineseMeaning().equals(newItem.getChineseMeaning())
                        && oldItem.isHiddenChinese() == newItem.isHiddenChinese());

            }
        });
        this.useCardView = useCardView;
        this.wordViewModel = wordViewModel;
    }


    //与RecyclerView绑定时调用
    @NonNull
    @Override
    public LayoutViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View itemView;
        if (useCardView) {
            itemView = layoutInflater.inflate(R.layout.card_layout_2, parent, false);
        } else {
            itemView = layoutInflater.inflate(R.layout.normal_layout_2, parent, false);
        }
        final LayoutViewHolder holder = new LayoutViewHolder(itemView);
        //长按事件弹出对话框
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new MaterialDialog.Builder(layoutInflater.getContext())
                        .title("请回答")
                        .content("你觉得这个app怎么样")
                        .positiveText("非常好")
                        .negativeText("还行")
                        .neutralText("很差")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(MaterialDialog dialog, DialogAction which) {
                                Toast toast = new Toast(layoutInflater.getContext());
                                View view = layoutInflater.inflate(R.layout.layout_toast,null);
                                ImageView imageView = view.findViewById(R.id.img_toast);
                                TextView textView = view.findViewById(R.id.tv_toast);
                                imageView.setImageResource(R.drawable.a);
                                textView.setText("你是个诚实的人~");
                                toast.setView(view);
                                toast.setGravity(Gravity.CENTER,0,0);
                                toast.setDuration(Toast.LENGTH_LONG);
                                toast.show();
                            }
                        })
                        .onNeutral(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(MaterialDialog dialog, DialogAction which) {
                                Toast toast = new Toast(layoutInflater.getContext());
                                View view = layoutInflater.inflate(R.layout.layout_toast,null);
                                ImageView imageView = view.findViewById(R.id.img_toast);
                                TextView textView = view.findViewById(R.id.tv_toast);
                                imageView.setImageResource(R.drawable.c);
                                textView.setText("请不要睁眼说瞎话！！");
                                toast.setView(view);
                                toast.setGravity(Gravity.CENTER,0,0);
                                toast.setDuration(Toast.LENGTH_LONG);
                                toast.show();
                            }
                        })
                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(MaterialDialog dialog, DialogAction which) {
                                Toast toast = new Toast(layoutInflater.getContext());
                                View view = layoutInflater.inflate(R.layout.layout_toast,null);
                                ImageView imageView = view.findViewById(R.id.img_toast);
                                TextView textView = view.findViewById(R.id.tv_toast);
                                imageView.setImageResource(R.drawable.b);
                                textView.setText("你瞅瞅，再考虑考虑~");
                                toast.setView(view);
                                toast.setGravity(Gravity.CENTER,0,0);
                                toast.setDuration(Toast.LENGTH_LONG);
                                toast.show();
                            }
                        })
                        .show();

                return false;
            }
        });
        //点击事件跳转到相应的百度翻译页面
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.baidu.com/sf_fanyi/?aldtype=30710#en/zh/" + holder.TvEnglish.getText());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                holder.itemView.getContext().startActivity(intent);
            }
        });

        //开关按钮功能
        holder.aSwitchHiddenHhinese.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Word word = (Word) holder.itemView.getTag(R.id.word_for_view_holder);
                if (isChecked) {
                    holder.TvChinese.setVisibility(View.GONE);
                    word.setHiddenChinese(true);
                    wordViewModel.updateWords(word);
                } else {
                    holder.TvChinese.setVisibility(View.VISIBLE);
                    word.setHiddenChinese(false);
                    wordViewModel.updateWords(word);
                }
            }
        });

        return holder;
    }

    //创建ViewHolder时调用
    @Override
    public void onBindViewHolder(@NonNull final LayoutViewHolder holder, int position) {
        final Word word = getItem(position);
        holder.itemView.setTag(R.id.word_for_view_holder, word);
        holder.TvNumber.setText(String.valueOf(position + 1));//word.getId()
        holder.TvEnglish.setText(word.getWord());
        holder.TvChinese.setText(word.getChineseMeaning());
        if (word.isHiddenChinese()) {
            holder.TvChinese.setVisibility(View.GONE);
            holder.aSwitchHiddenHhinese.setChecked(true);
        } else {
            holder.TvChinese.setVisibility(View.VISIBLE);
            holder.aSwitchHiddenHhinese.setChecked(false);
        }


    }

    //当ViewHolder出现在屏幕上时给他设置好序列号
    @Override
    public void onViewAttachedToWindow(@NonNull LayoutViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.TvNumber.setText(String.valueOf(holder.getAdapterPosition() + 1));
    }

    //管理RecyclerView界面布局
    static class LayoutViewHolder extends RecyclerView.ViewHolder {
        TextView TvNumber, TvEnglish, TvChinese;
        Switch aSwitchHiddenHhinese;

        LayoutViewHolder(@NonNull View itemView) {
            super(itemView);
            TvNumber = itemView.findViewById(R.id.tv_number);
            TvEnglish = itemView.findViewById(R.id.tv_english);
            TvChinese = itemView.findViewById(R.id.tv_chinese);
            aSwitchHiddenHhinese = itemView.findViewById(R.id.switch_hidden_chinese);
        }
    }
}
