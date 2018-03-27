package com.robby.lesson06_android_recycler_view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robby.lesson06_android_recycler_view.R;
import com.robby.lesson06_android_recycler_view.entity.Student;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Robby Tan
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private ArrayList<Student> students;
    private StudentDataClickedListener studentDataClickedListener;

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        final Student student = getStudents().get(position);
        holder.lblName.setText(student.getDetails());
        holder.lblDepartment.setText(student.getDepartment());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentDataClickedListener != null) {
                    studentDataClickedListener.onStudentDataClicked(student);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return getStudents().size();
    }

    public void setStudents(ArrayList<Student> students) {
        getStudents().clear();
        getStudents().addAll(students);
        notifyDataSetChanged();
    }

    private ArrayList<Student> getStudents() {
        if (students == null) {
            students = new ArrayList<>();
        }
        return students;
    }

    public void setStudentDataClickedListener(StudentDataClickedListener studentDataClickedListener) {
        this.studentDataClickedListener = studentDataClickedListener;
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView lblName;
        @BindView(R.id.tv_department)
        TextView lblDepartment;

        public StudentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface StudentDataClickedListener {

        void onStudentDataClicked(Student student);
    }
}
