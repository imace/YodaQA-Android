package in.vesely.eclub.yodaqa.view;

import android.content.Context;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.ColorRes;

import in.vesely.eclub.yodaqa.R;
import in.vesely.eclub.yodaqa.adapters.BindableLinearLayout;
import in.vesely.eclub.yodaqa.restclient.YodaAnswer;
import in.vesely.eclub.yodaqa.utils.ColorUtils;

/**
 * Created by vesely on 6/16/15.
 */
@EViewGroup(R.layout.answer_item)
public class AnswerItem extends BindableLinearLayout<YodaAnswer> {

    @ViewById(R.id.text)
    protected TextView text;

    @ViewById(R.id.position)
    protected TextView position;

    @ViewById(R.id.confidence)
    protected TextView confidence;

    @ColorRes(R.color.myAccentColorDark)
    protected int accDarkColor;

    @ColorRes(R.color.myAccentColor)
    protected int accColor;

    public AnswerItem(Context context) {
        super(context);
    }

    @Override
    public void bind(YodaAnswer data, int pos) {
        text.setText(data.getText());
        position.setText(String.format("%2d.", pos + 1));
        confidence.setText(String.format("%3.1f %%", data.getConfidence() * 100));
        confidence.setTextColor(ColorUtils.interpolate(accColor, accDarkColor, (float) data.getConfidence()));
    }
}