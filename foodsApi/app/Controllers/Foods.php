<?php namespace App\Controllers;
 
use CodeIgniter\RESTful\ResourceController;
use CodeIgniter\API\ResponseTrait;
use App\Models\FoodsModel;
 
class Foods extends ResourceController
{
    use ResponseTrait;
    // kode get all foods
    public function index()
    {
        $model = new FoodsModel();
        $data = $model->findAll();
        return $this->respond($data, 200);
    }
 
    // kode get single foods
    public function show($id = null)
    {
        $model = new FoodsModel();
        $data = $model->getWhere(['food_code' => $id])->getResult();
        if($data){
            return $this->respond($data);
        }else{
            return $this->failNotFound('No Data Found with id '.$id);
        }
    }
 
    // kode create a foods
    public function create()
    {
        $model = new FoodsModel();
        $data = [
            'categories_food' => $this->request->getPost('categories_food'),
            'food_name' => $this->request->getPost('food_name'),
            'price' => $this->request->getPost('price'),
            'stock' => $this->request->getPost('stock'),
            'image' => $this->request->getPost('image')
        ];

        $model->insert($data);
        $response = [
            'status'   => 201,
            'error'    => null,
            'messages' => [
                'success' => 'Data Saved'
            ]
        ];
         
        return $this->respondCreated($data, 201);
    }
 
    // kode update foods
    public function update($id = null)
    {
        $model = new FoodsModel();
        $json = $this->request->getJSON();
        if($json){
            $data = [
                'categories_food' => $json->categories_food,
                'food_name' => $json->food_name,
                'price' => $json->price,
                'stock' => $json->stock,
                'image' => $json->image
            ];
        }else{
            $input = $this->request->getRawInput();
            $data = [
                'categories_food' => $input['categories_food'],
                'food_name' => $input['food_name'],
                'price' => $input['price'],
                'stock' => $input['stock'],
                'image' => $input['image']
            ];
        }
        // kode Insert to Database
        $model->update($id, $data);
        $response = [
            'status'   => 200,
            'error'    => null,
            'messages' => [
                'success' => 'Data Updated'
            ]
        ];
        return $this->respond($response);
    }
 
    // kode delete foods
    public function delete($id = null)
    {
        $model = new FoodsModel();
        $data = $model->find($id);
        if($data){
            $model->delete($id);
            $response = [
                'status'   => 200,
                'error'    => null,
                'messages' => [
                    'success' => 'Data Deleted'
                ]
            ];
             
            return $this->respondDeleted($response);
        }else{
            return $this->failNotFound('No Data Found with id '.$id);
        }
         
    }
 
}

