package com.hovedopgave.restservice.Service;

import com.hovedopgave.restservice.Exceptions.NewsNotFoundException;
import com.hovedopgave.restservice.Models.CoWorkerMonthVote;
import com.hovedopgave.restservice.Models.PollVotes;
import com.hovedopgave.restservice.Models.Polls;
import com.hovedopgave.restservice.Repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {
    @Autowired
    PollRepository pollRepository;

    public Polls create(Polls newPoll){
        return pollRepository.save(newPoll);
    }

    public List<Polls> findAll(){
        return pollRepository.findAll();
    }

    public Polls findOne(long id){
        return pollRepository.findById(id)
                .orElseThrow(() -> new NewsNotFoundException(id));
    }

    public void updateOne(Polls newPoll, Long id){
        pollRepository.updatePoll(id, newPoll.getTitle(), newPoll.getDescription(), newPoll.getDateEnd(), newPoll.getDateStart(), newPoll.getType(), newPoll.getImagePath());
    }

    public void deleteOne(long id){
        pollRepository.deleteById(id);
    }

    public int createVote(PollVotes newPollVotes){
        return pollRepository.savePollVote(newPollVotes.getPollAnswers().getId(), newPollVotes.getPolls().getPollId(), newPollVotes.getCoWorkers().getId());
    }

    public void deleteVote(Long pollId, Long coWorkerId){
        pollRepository.deleteVote(coWorkerId,pollId);
    }

    public int createCoWorkerMonthVote(CoWorkerMonthVote CoWorkerMonthVote){
        return pollRepository.saveCoWorkerMonthVote(CoWorkerMonthVote.getCoWorkers().getId(), CoWorkerMonthVote.getPolls().getPollId(), CoWorkerMonthVote.getVotedCoWorker().getId());
    }

    public List<Object[]> getResult(long id){
        return pollRepository.getPollResult(id);
    }
}
