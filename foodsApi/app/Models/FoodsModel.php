<?php namespace App\Models;
 
use CodeIgniter\Model;
 
class FoodsModel extends Model
{
    protected $table = 'tabel_foods';
    protected $primaryKey = 'food_code';
    protected $allowedFields = ['categories_food','food_name','price','stock','image'];
}




