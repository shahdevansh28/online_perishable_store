package com.online_perishable_store.user;

import org.springframework.stereotype.Service;

@Service
public class TryBean {
    
    public String nothing="success +++++++++++++++++++";
    @Override
    public String toString(){
        return nothing;
    }
}
