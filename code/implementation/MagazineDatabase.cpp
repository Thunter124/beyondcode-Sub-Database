#include "MagazineDatabase.h"

#include "Magazine.h"
#include <vector>

using namespace std;


bool MagazineDatabase::removeMagazine(Magazine &mag){
    for(unsigned int i = 0; i < magazineList.size(); ++i){
        if(magazineList.at(i).getTitle() == mag.getTitle()){
            magazineList.erase(magazineList.begin() + i);
            return true;
        }
    }
    return false;
}


Magazine MagazineDatabase::getMagazineByTitle(string title){
    for(unsigned int i = 0; i < magazineList.size(); ++i){
        if(magazineList.at(i).getTitle() == title){
            return magazineList.at(i);
        }
    }
    return magazineList.at(0);
}




