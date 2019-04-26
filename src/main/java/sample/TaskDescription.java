package sample;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TaskDescription {
    String title;
    String priority;
    LocalDate date;
    String description;

    public TaskDescription(TaskDescription tmp)
    {
        this.title=tmp.title;
        this.priority=tmp.priority;
        this.date=tmp.date;
        this.description=tmp.description;
    }

}
