package edu.cnm.deepdive.zoomattendance.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import edu.cnm.deepdive.zoomattendance.R;
import edu.cnm.deepdive.zoomattendance.databinding.ItemMeetingBinding;
import edu.cnm.deepdive.zoomattendance.model.entity.ZoomMeeting;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class MeetingAdapter extends ArrayAdapter<ZoomMeeting> {

  private final LayoutInflater inflater;
  private final DateFormat formatter;
  private final List<ZoomMeeting> meetings;

  public MeetingAdapter(@NonNull Context context,
      @NonNull List<ZoomMeeting> meetings) {
    super(context, R.layout.item_meeting, meetings);
    inflater = LayoutInflater.from(context);
    formatter = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
    this.meetings = meetings;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    ItemMeetingBinding binding = (convertView != null)
        ? ItemMeetingBinding.bind(convertView)
        : ItemMeetingBinding.inflate(inflater, parent, false);
    ZoomMeeting meeting = getItem(position);
    binding.topic.setText(meeting.getTopic());
    binding.start.setText(formatter.format(new Date(meeting.getStarted().getEpochSecond())));
    // TODO: 11/22/23 Format the value returned from meeting.getDuration into hhh:mm, then invoke binding.duration.setText with the result
    return binding.getRoot();
  }
}
