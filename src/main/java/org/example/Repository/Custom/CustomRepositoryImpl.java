package org.example.Repository.Custom;

import org.example.Repository.CustomRepository;
import org.example.Dto.PendingDto;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CustomRepositoryImpl implements CustomRepository {
    private Session session;

    @Override
    public List<PendingDto> getPendingDtoList() {
        String hql = "SELECT bb.id, m.id, m.full_name, bb.dueDate " +
                "FROM BorrowBook bb " +
                "JOIN bb.member m " +
                "WHERE bb.status = 'Pending'";
        Query<Object[]> query = session.createQuery(hql);
        List<Object[]> results = query.getResultList();

        System.out.println("Number of results: " + results.size());
        for (Object[] result : results) {
            System.out.println(Arrays.toString(result));
        }

        List<PendingDto> pendingDtoList = new ArrayList<>();
        for (Object[] result : results) {
            int borrowBookId = (int) result[0];
            int memberId = (int) result[1];
            String memberName = (String) result[2];
            String dueDate = result[3].toString(); // Assuming dueDate is a Date object

            PendingDto pendingDto = new PendingDto(borrowBookId, memberId, memberName, dueDate);
            pendingDtoList.add(pendingDto);
            System.out.println(1);
        }

        return pendingDtoList;
    }

    @Override
    public void SetSession(Session session){
        this.session = session;
    }
}
